package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import CD_autowire.CDPlayer;
import CD_autowire.CompactDisc;
import CD_autowire.MediaPlayer;
import CD_autowire.SgtPeppers;

@Configuration//��������Ϊһ��������
@ComponentScan(basePackageClasses= {CDPlayer.class})//���û����������ɨ������������ͬ�İ�
/*@Import(SunshineConfig.class)//����������javaConfig����
*///javaConfigǿ�󣬰�ȫ�����ع��Ѻ�
public class CDPlayerConfig {
	//�������������ǵĴ������õ������������������ǲ���ͨ��@Autowireʵ���Զ�ƥ�䣬��ʱ���Ҫ�õ���ʾ����
	@Bean
	public CompactDisc sgtPeppers() {//����ͨ��java���߼�ʵ���Զ�����
		return new SgtPeppers();
	}
	@Bean
	public MediaPlayer cdPlayer() {
		return new CDPlayer(sgtPeppers());/*��ʱ��sgtPeppers()������ÿ�ε��ã���������һ���µ�
		CompactDiscʵ�������������п���֮��������һ��cdֻ�ܱ�һ�����������ţ����������������
		spring��bean���ǵ����ģ�spring�����ض�sgtPeppers()������ÿ�ε��ã�ȷ�����ص���spring������bean*/
		 
		}
	public MediaPlayer cdPlayer(CompactDisc compactDisc) {//ͨ��������ע��
		return new CDPlayer(compactDisc);
	}//��һ��ע�뷽ʽ����Ҫ����sgtPeppers��bean��������һ������
	
}
