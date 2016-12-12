package nu.muntea.qb.rmi;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import nu.muntea.qb.rmi.client.QueryService;
import nu.muntea.qb.rmi.server.OracleImpl;
import nu.muntea.qb.rmi.server.OracleService;

public class RmiBindingTest {

	@Test(timeout = 10000l)
	public void clientServerCommunication() throws InterruptedException {

		OracleService server = new OracleService();
		server.register(new OracleImpl());
		
		QueryService client = new QueryService();
		String answer = client.askQuestion("test");

		Assert.assertThat(answer, Matchers.endsWith("nu"));
	}
}
