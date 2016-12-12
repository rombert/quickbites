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
