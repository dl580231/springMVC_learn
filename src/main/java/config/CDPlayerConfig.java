package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import CD_autowire.CDPlayer;
import CD_autowire.CompactDisc;
import CD_autowire.MediaPlayer;
import CD_autowire.SgtPeppers;

@Configuration//用来声明为一个配置类
@ComponentScan(basePackageClasses= {CDPlayer.class})//如果没有其他配置扫描与配置类相同的包
/*@Import(SunshineConfig.class)//导入其他的javaConfig配置
*///javaConfig强大，安全，对重构友好
public class CDPlayerConfig {
	//当我们想在我们的代码中用到第三方苦的组件，我们不能通过@Autowire实现自动匹配，这时候就要用到显示配置
	@Bean
	public CompactDisc sgtPeppers() {//可以通过java的逻辑实现自动播放
		return new SgtPeppers();
	}
	@Bean
	public MediaPlayer cdPlayer() {
		return new CDPlayer(sgtPeppers());/*这时对sgtPeppers()方法的每次调用，都会生成一个新的
		CompactDisc实例，在物理中有可行之处，例如一张cd只能被一个播放器播放，但是在软件领域中
		spring的bean都是单例的，spring会拦截对sgtPeppers()方法的每次调用，确保返回的是spring常见的bean*/
		 
		}
	public MediaPlayer cdPlayer(CompactDisc compactDisc) {//通过构造器注入
		return new CDPlayer(compactDisc);
	}//另一种注入方式，不要求与sgtPeppers的bean的配置在一个类中
	
}
