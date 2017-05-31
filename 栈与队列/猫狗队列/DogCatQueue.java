package algorithms;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 猫狗类以及宠物类如下，要求实现一种队列，要求如下
 * 1、用户可以调用add方法将cat类或dog类的实例放入队列中
 * 2、用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出
 * 3、用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
 * 4、用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出
 * 5、用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例
 * 6、用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例
 * 7、用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例
 */
class Pet{
	private String type;
	public Pet(String type){
		this.type = type;
	}
	public String getPetType(){
		return this.type;
	}
	@Override
	public String toString() {
		return "Pet [type=" + type + "]";
	}
	
}
class Dog extends Pet{
	public Dog(){
		super("dog");
	}
	
}
class Cat extends Pet{
	public Cat(){
		super("cat");
	}
}
/********************************************************************************************/
class EnterQueue{
	private Pet pet;
	private long count;//存放顺序
	public EnterQueue(Pet pet,long count){
		this.pet = pet;
		this.count = count;
	}
	public Pet getPet(){
		return this.pet;
	}
	public long getCount(){
		return this.count;
	}

}
public class DogCatQueue {//猫狗队列
	private Queue<EnterQueue> QueueDog;
	private Queue<EnterQueue> QueueCat;
	private long count;
	public DogCatQueue(){//构造器
		this.QueueDog = new LinkedList<EnterQueue> ();
		this.QueueCat = new LinkedList<EnterQueue> ();
	}
	public void add(Pet pet){
		if(pet.getPetType().equals("dog")){//判断是否为dog
			QueueDog.add(new EnterQueue(pet,this.count++));//每存入一个，存入count的值然后++
		}else if(pet.getPetType().equals("cat")){//判断是否为cat
			QueueCat.add(new EnterQueue(pet,this.count++));//每存入一个，存入count的值然后++
		}else{
			throw new RuntimeException("类型错误");
		}
	}
	public Pet pollAll(){//弹出所有类
		if(!this.QueueDog.isEmpty() && !this.QueueCat.isEmpty()){
			if(this.QueueDog.peek().getCount() < this.QueueCat.peek().getCount()){//返回两个队列中count值比较小的那个
			return this.QueueDog.poll().getPet();
				}else{
						return this.QueueCat.poll().getPet();
					 }
		}else if(!this.QueueDog.isEmpty()){//如果两个队列中有一个不为空则执行这一步
			return this.QueueDog.poll().getPet();
		}else if(!this.QueueCat.isEmpty()){//如果两个队列中有一个不为空则执行这一步
			return this.QueueCat.poll().getPet();
		}else
			throw new RuntimeException("队列为空！");
		}
	
	public Pet pollDog(){//顺序弹出Dog类
		if(this.QueueDog.isEmpty()){
			throw new RuntimeException("队列为空");
		}else{
			return this.QueueDog.poll().getPet();
		}
	}
	public Pet pollCat(){//顺序弹出Cat类
		if(this.QueueCat.isEmpty()){
			throw new RuntimeException("队列为空");
		}else
			return this.QueueCat.poll().getPet();
	}
	public boolean isEmpty(){//判断队列是否为空
		return this.QueueDog.isEmpty() && this.QueueCat.isEmpty();
	}
	public boolean isDogEmpty(){
		return this.QueueDog.isEmpty();
	}
	public Boolean isCatEmpty(){
		return this.QueueCat.isEmpty();
	}
	public static void main(String[] args) {//进行测试
		DogCatQueue P1 = new DogCatQueue();
		P1.add(new Dog());
		P1.add(new Cat());
		P1.add(new Dog());
		P1.add(new Dog());
		P1.add(new Cat());
		P1.add(new Cat());
		for(int i = 1;i<=6;i++){
			System.out.println(i+"--->"+P1.pollAll());
		}
	}
}
