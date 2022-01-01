package hu.webuni.log.czunyi.config;

import java.util.TreeMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "log")
@Component
public class LogConfigProperties {

	private Delay delay = new Delay();

	public Delay getDelay() {
		return delay;
	}

	public void setDelay(Delay delay) {
		this.delay = delay;
	}
	
	public static class Delay{
		
		private TreeMap<Integer, Double> limits;

		public TreeMap<Integer, Double> getLimits() {
			return limits;
		}

		public void setLimits(TreeMap<Integer, Double> limits) {
			this.limits = limits;
		}
	}
}
