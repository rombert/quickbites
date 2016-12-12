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
