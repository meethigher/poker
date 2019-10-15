package demo20;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 斗地主：
 * 1.准备牌
 * 2.洗牌
 * 3.发牌
 * 4.看牌
 */
public class DouDiZhu {
	public static void main(String[] args) {
		/*
		 * 1.准备牌
		 */
		//定义一个存储54张牌的ArrayList集合，泛型使用字符串
		ArrayList<String> poker=new ArrayList<String>();
		//定义两个数组，一个数组存储牌的花色，一个存储序号
		String[] colors= {
				"♥","♠","♣","♦"
		};
		String[] numbers= {
				"2","A","K","Q","J","10","9","8","7","6","5","4","3"
		};
		//先把大王跟小王存储到集合中
		poker.add("大王");
		poker.add("小王");
		//循环遍历两个数组，组装52张牌
		for (String number : numbers) {
			for (String color : colors) {
				//把组装好的牌存储到poker牌当中
				poker.add(color+number);
			}
		}
//		System.out.println(poker);
		
		/*
		 * 2.洗牌
		 * 使用集合的工具类Collections中的方法
		 * static void shuffle(List<?> list) 使用默认随机源对指定列表进行置换
		 */
		Collections.shuffle(poker);
//		System.out.println(poker);
		/*
		 * 3.发牌
		 * 定义四个集合，存储3个玩家和1底牌
		 */
		ArrayList<String> player01=new ArrayList<String>();
		ArrayList<String> player02=new ArrayList<String>();
		ArrayList<String> player03=new ArrayList<String>();
		ArrayList<String> diPai=new ArrayList<String>();
		
		//遍历poker集合，获取每一张牌，使用poker的索引，%3给三个玩家轮流发牌
		//剩余三张牌给底牌
		//注意：
		//先判断底牌（i）>=51,否则就发没了
		for (int i = 0; i < poker.size(); i++) {
			//获取每一张牌
			String p=poker.get(i);
			//轮流发牌
			if(i>=51) {//底牌发牌
				diPai.add(p);
			}else if(i%3==0){//玩家1发牌
				player01.add(p);
			}else if(i%3==1) {//玩家2发牌
				player02.add(p);
			}else if(i%3==2) {//玩家3发牌
				player03.add(p);
			}
		}
		/*
		 * 4.看牌
		 */
		System.out.println("紫女："+player01);
		System.out.println("焰灵姬："+player02);
		System.out.println("潮女妖："+player03);
		System.out.println("底牌："+diPai);
	}
}
