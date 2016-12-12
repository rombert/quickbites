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
package nu.muntea.qb.rmi.registry;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiRegistry {

	public static void register(Remote object, String name) throws RemoteException {
		
		registry().rebind(name, object);
	}

	private static Registry registry() throws RemoteException {
		try {
			return LocateRegistry.createRegistry(1099);
		} catch ( RemoteException e) {
			return LocateRegistry.getRegistry();
		}
	}

	public static Object retrieve(String name) throws RemoteException, NotBoundException {
		
		return registry().lookup(name);
	}
}
