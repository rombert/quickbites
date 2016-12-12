/*
 * Copyright (C) 2016 Robert Munteanu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
