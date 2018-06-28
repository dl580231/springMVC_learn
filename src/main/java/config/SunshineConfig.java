package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import CD_autowire.CompactDisc;
import CD_autowire.TheSunshine;

@Configuration
public class SunshineConfig {
	@Bean
	public CompactDisc theSunshine() {
		return new TheSunshine();
	}
}
