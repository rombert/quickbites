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
package nu.muntea.qb.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import nu.muntea.qb.rmi.registry.Names;
import nu.muntea.qb.rmi.registry.RmiRegistry;

public class OracleService {

	public void register(Oracle oracle) {
		
		try {
			Oracle stub = (Oracle) UnicastRemoteObject.exportObject(oracle, 0);
			RmiRegistry.register(stub, Names.REGISTRY_NAME_ORACLE);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}
}
