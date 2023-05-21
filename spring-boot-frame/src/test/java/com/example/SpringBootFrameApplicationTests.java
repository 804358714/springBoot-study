package com.example;

import com.example.entity.Account;
import com.example.entity.AccountDetail;
import com.example.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootFrameApplicationTests {

	@Resource
	AccountRepository repository;
	@Test
	void contextLoads() {
		repository.updatePasswordById(1,"654321");
//		repository.findById(1).ifPresent(System.out::println);
//		System.out.println(repository.findAccountByUsername("test"));
//		System.out.println(repository.findAccountByUsernameLike("%t%"));
	}

	@Transactional
	@Test
	void test(){
		//一对多
//		repository.findById(2).ifPresent(account -> {
//			account.getScoreList().forEach(System.out::println);
//		});
		//多对一
//		repository.findById(1).ifPresent(account -> {
//			account.getScoreList().forEach(score -> {
//				System.out.println("课程名称："+score.getSubject().getName());
//				System.out.println("得分："+score.getScore());
//				System.out.println("任课教师："+score.getSubject().getTeacher().getName());
//			});
//		});
		//多对多
		repository.findById(1).ifPresent(account -> {
			account.getScoreList().forEach(score -> {
				System.out.println("课程名称："+score.getSubject().getName());
				System.out.println("得分："+score.getScore());
				System.out.println("任课教师："+score.getSubject().getTeacher());
			});
		});
	}

	@Test
	void addAccount(){
//		Account account = new Account();
//		account.setUsername("Admin");
//		account.setPassword("123456");
//		account = repository.save(account);  //返回的结果会包含自动生成的主键值
//		System.out.println("插入时，自动生成的主键ID为："+account.getId());
		Account account = new Account();
		account.setUsername("五五开");
		account.setPassword("123456");
		AccountDetail detail = new AccountDetail();
		detail.setAddress("上海市");
		detail.setPhone("1234567890");
		detail.setEmail("73281937@qq.com");
		detail.setRealName("lbw");
		account.setDetail(detail);
		account = repository.save(account);
		System.out.println("插入时，自动生成的主键ID为："+account.getId()+"，外键ID为："+account.getDetail().getId());
	}

	@Test
	void deleteAccount(){
		repository.deleteById(2);   //根据ID删除对应记录
	}

	@Test
	void pageAccount() {
		repository.findAll(PageRequest.of(0, 1)).forEach(System.out::println);  //直接分页
	}

}
