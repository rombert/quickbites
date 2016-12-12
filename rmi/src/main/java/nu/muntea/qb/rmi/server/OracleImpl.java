package nu.muntea.qb.rmi.server;

import java.rmi.RemoteException;

import nu.muntea.qb.rmi.model.Request;

public class OracleImpl implements Oracle {

	@Override
	public String query(Request q) throws RemoteException {
		return q.getWhat() + ": nu, nu, nu";
	}
}
