package nu.muntea.qb.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import nu.muntea.qb.rmi.model.Request;

public interface Oracle extends Remote{

	String query(Request req) throws RemoteException;
}
