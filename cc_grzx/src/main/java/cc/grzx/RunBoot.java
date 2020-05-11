package cc.grzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"cc.grzx.dao"})
public class RunBoot {
	
	public static void main(String[] args) {
		SpringApplication.run(RunBoot.class,args);
	}																																																												

}
