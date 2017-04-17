package cn.app.mapper.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.app.mapper.OrdersMapperCustom;
import cn.app.mapper.UserMapper;
import cn.app.po.Orders;
import cn.app.po.OrdersCustom;
import cn.app.po.User;

public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;

	// 姝ゆ柟娉曟槸鍦ㄦ墽琛宼estFindUserById涔嬪墠鎵ц
	@Before
	public void setUp() throws Exception {
		// 鍒涘缓sqlSessionFactory

		// mybatis閰嶇疆鏂囦欢
		String resource = "SqlMapConfig.xml";
		// 寰楀埌閰嶇疆鏂囦欢娴�
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 鍒涘缓浼氳瘽宸ュ巶锛屼紶鍏ybatis鐨勯厤缃枃浠朵俊鎭�
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersUser() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 鍒涘缓浠ｇ悊瀵硅薄
		OrdersMapperCustom ordersMapperCustom = sqlSession
				.getMapper(OrdersMapperCustom.class);

		// 璋冪敤maper鐨勬柟娉�
		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();

		System.out.println(list);

		sqlSession.close();
	}

	@Test
	public void testFindOrdersUserResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 鍒涘缓浠ｇ悊瀵硅薄
		OrdersMapperCustom ordersMapperCustom = sqlSession
				.getMapper(OrdersMapperCustom.class);

		// 璋冪敤maper鐨勬柟娉�
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();

		System.out.println(list);

		sqlSession.close();
	}

	@Test
	public void testFindOrdersAndOrderDetailResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 鍒涘缓浠ｇ悊瀵硅薄
		OrdersMapperCustom ordersMapperCustom = sqlSession
				.getMapper(OrdersMapperCustom.class);

		// 璋冪敤maper鐨勬柟娉�
		List<Orders> list = ordersMapperCustom
				.findOrdersAndOrderDetailResultMap();

		System.out.println(list);

		sqlSession.close();
	}

	@Test
	public void testFindUserAndItemsResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 鍒涘缓浠ｇ悊瀵硅薄
		OrdersMapperCustom ordersMapperCustom = sqlSession
				.getMapper(OrdersMapperCustom.class);

		// 璋冪敤maper鐨勬柟娉�
		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();

		System.out.println(list);

		sqlSession.close();
	}

	// 鏌ヨ璁㈠崟鍏宠仈鏌ヨ鐢ㄦ埛锛岀敤鎴蜂俊鎭娇鐢ㄥ欢杩熷姞杞�
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();// 鍒涘缓浠ｇ悊瀵硅薄
		OrdersMapperCustom ordersMapperCustom = sqlSession
				.getMapper(OrdersMapperCustom.class);
		// 鏌ヨ璁㈠崟淇℃伅锛堝崟琛級
		List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();

		// 閬嶅巻涓婅竟鐨勮鍗曞垪琛�
		for (Orders orders : list) {
			// 鎵цgetUser()鍘绘煡璇㈢敤鎴蜂俊鎭紝杩欓噷瀹炵幇鎸夐渶鍔犺浇
			User user = orders.getUser();
			System.out.println(user);
		}

	}

	// 涓�骇缂撳瓨娴嬭瘯
	@Test
	public void testCache1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();// 鍒涘缓浠ｇ悊瀵硅薄
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 涓嬭竟鏌ヨ浣跨敤涓�釜SqlSession
		// 绗竴娆″彂璧疯姹傦紝鏌ヨid涓�鐨勭敤鎴�
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);

		// 濡傛灉sqlSession鍘绘墽琛宑ommit鎿嶄綔锛堟墽琛屾彃鍏ャ�鏇存柊銆佸垹闄わ級锛屾竻绌篠qlSession涓殑涓�骇缂撳瓨锛岃繖鏍峰仛鐨勭洰鐨勪负浜嗚缂撳瓨涓瓨鍌ㄧ殑鏄渶鏂扮殑淇℃伅锛岄伩鍏嶈剰璇汇�

		// 鏇存柊user1鐨勪俊鎭�
		// user1.setUsername("娴嬭瘯鐢ㄦ埛22");
		// userMapper.updateUser(user1);
		// //鎵цcommit鎿嶄綔鍘绘竻绌虹紦瀛�
		// sqlSession.commit();

		// 绗簩娆″彂璧疯姹傦紝鏌ヨid涓�鐨勭敤鎴�
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);

		sqlSession.close();

	}

	// 浜岀骇缂撳瓨娴嬭瘯
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		// 鍒涘缓浠ｇ悊瀵硅薄
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		// 绗竴娆″彂璧疯姹傦紝鏌ヨid涓�鐨勭敤鎴�
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		
		//杩欓噷鎵ц鍏抽棴鎿嶄綔锛屽皢sqlsession涓殑鏁版嵁鍐欏埌浜岀骇缂撳瓨鍖哄煙
		sqlSession1.close();
		
		
//		//浣跨敤sqlSession3鎵цcommit()鎿嶄綔
//		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
//		User user  = userMapper3.findUserById(1);
//		user.setUsername("寮犳槑鏄�);
//		userMapper3.updateUser(user);
//		//鎵ц鎻愪氦锛屾竻绌篣serMapper涓嬭竟鐨勪簩绾х紦瀛�
//		sqlSession3.commit();
//		sqlSession3.close();
		
		

		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		// 绗簩娆″彂璧疯姹傦紝鏌ヨid涓�鐨勭敤鎴�
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);

		sqlSession2.close();

	}

}
