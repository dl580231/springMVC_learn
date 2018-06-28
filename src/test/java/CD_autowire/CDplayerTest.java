package CD_autowire;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.CDPlayerConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDplayerTest {
	@Autowired()
	private CompactDisc cd;
	
	@Autowired
	private MediaPlayer cp;
	
/*	@Resource(name="theSunshine")
	private CompactDisc theSunshine;*/
	
	@Test
	public void cd() {
		assertNotNull(cd);
	}
	
	
	@Test
	public void play() {
		cp.play();
	}
	
/*	@Test
	public void mix_javaConfig() {
		assertNotNull(theSunshine);
	}*/
}
