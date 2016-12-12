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
