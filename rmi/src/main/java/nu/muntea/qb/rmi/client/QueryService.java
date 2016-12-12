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
package nu.muntea.qb.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import nu.muntea.qb.rmi.model.Request;
import nu.muntea.qb.rmi.registry.Names;
import nu.muntea.qb.rmi.registry.RmiRegistry;
import nu.muntea.qb.rmi.server.Oracle;

public class QueryService {

	public String askQuestion(String q) {
		try {
			Oracle oracle = (Oracle) RmiRegistry.retrieve(Names.REGISTRY_NAME_ORACLE);
			
			return oracle.query(new Request("trec la rețele?"));
		} catch (RemoteException | NotBoundException e) {
			throw new RuntimeException(e);
		}		
	}
}
