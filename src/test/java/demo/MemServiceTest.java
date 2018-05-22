package demo;

import com.nettyrpc.client.RPCFuture;
import com.nettyrpc.client.RpcClient;
import com.nettyrpc.client.proxy.IAsyncObjectProxy;
import com.nettyrpc.test.client.HelloPersonService;
import com.nettyrpc.test.client.HelloService;
import com.nettyrpc.test.client.Person;
import com.newgen.bean.Mem;
import com.newgen.bean.News;
import com.newgen.service.MemService;
import com.newgen.service.NewsService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:client-spring.xml")
public class MemServiceTest {

    @Autowired
    private RpcClient rpcClient;
    
    @Autowired
    private MemService memservice;
    
    @Autowired
    private NewsService newsservice;

    @Test
    public void helloTest1() {
        HelloService helloService = rpcClient.create(HelloService.class);
       // String result = helloService.hello("World");
       // Assert.assertEquals("Hello! World", result);
        
       // System.out.println(result);

    }
    
    @Test
    public void testSaveMem(){
    	
    	Mem mem = new Mem();
    	
    	
    	mem.setId(UUID.randomUUID().toString());
    	SimpleDateFormat sf =new SimpleDateFormat("yyy-MM-dd");
    	
    	mem.setLoginname("liusl23333334444444444");
    	mem.setPassword("123456333333333");
    	
    	mem.setCreatetime(sf.format(new Date()));
    	
    	
    	
    	MemService memservice = rpcClient.create(MemService.class);
    	
    		memservice.save(mem);
    	
    }
    
    
    @Test
    public void testGetMem(){
    	
    	
    	
    	
    	
    	MemService memservice = rpcClient.create(MemService.class);
    //	System.out.println(memservice+"###########@@@@");
    	
    		
    	List<Mem> all = memservice.getAll();
    		
    		System.out.println(all);
    	
    		Mem byID = memservice.getByID("bea2ce57-cbc4-4ae7-8d4a-ff94ca9d89f2");
    		
    		System.out.println(byID);
    		
    		
    	
    }
    
    /**
     * 实验成功   不需要代码改变  实现dubbo 功能
     */
    @Test
    public void testGetMemWithoutCreateClient(){
    	
    	
    	List<Mem> all = memservice.getAll();
    	
    	System.out.println(all);
    	
    	Mem byID = memservice.getByID("bea2ce57-cbc4-4ae7-8d4a-ff94ca9d89f2");
    	
    	System.out.println(byID);
    	
    	
    	
    }
    
    /**
     * 实验成功   不需要代码改变  实现dubbo 功能
     */
    @Test
    public void testProxy(){
    	
    	
    	List<News> all = newsservice.getAll();
    	//List<Mem> all2 = memservice.getAll();
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @Test
    public void helloTest2() {
        HelloService helloService = rpcClient.create(HelloService.class);
        Person person = new Person("Yong", "Huang");
        String result = helloService.hello(person);
       // Assert.assertEquals("Hello! Yong Huang", result);
        
        
        System.out.println(result);
    }

    @Test
    public void helloPersonTest(){
        HelloPersonService helloPersonService = rpcClient.create(HelloPersonService.class);
        int num = 5;
        List<Person>  persons = helloPersonService.GetTestPerson("xiaoming",num);
        List<Person> expectedPersons = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            expectedPersons.add(new Person(Integer.toString(i), "xiaoming"));
        }
        assertThat(persons, equalTo(expectedPersons));

        for (int i = 0; i<persons.size(); ++i){
            System.out.println(persons.get(i));
        }
    }

    @Test
    public void helloFutureTest1() throws ExecutionException, InterruptedException {
        IAsyncObjectProxy helloService = rpcClient.createAsync(HelloService.class);
        RPCFuture result = helloService.call("hello", "World");
        Assert.assertEquals("Hello! World", result.get());
    }

    @Test
    public void helloFutureTest2() throws ExecutionException, InterruptedException {
        IAsyncObjectProxy helloService = rpcClient.createAsync(HelloService.class);
        Person person = new Person("Yong", "Huang");
        RPCFuture result = helloService.call("hello", person);
        Assert.assertEquals("Hello! Yong Huang", result.get());
    }

    @Test
    public void helloPersonFutureTest1() throws ExecutionException, InterruptedException {
        IAsyncObjectProxy helloPersonService = rpcClient.createAsync(HelloPersonService.class);
        int num = 5;
        RPCFuture result = helloPersonService.call("GetTestPerson", "xiaoming", num);
        List<Person> persons = (List<Person>) result.get();
        List<Person> expectedPersons = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            expectedPersons.add(new Person(Integer.toString(i), "xiaoming"));
        }
        assertThat(persons, equalTo(expectedPersons));

        for (int i = 0; i < num; ++i) {
            System.out.println(persons.get(i));
        }
    }
}
