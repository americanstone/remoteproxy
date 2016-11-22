package com.jonasboner.remoting.proxy;

import com.jonasboner.remoting.proxy.models.IPerson;
import com.jonasboner.remoting.proxy.models.Person;

/**
 * Created by ddcgordonz on 11/21/16.
 */
public class App {

	public static void main(String[] args) {
		RemoteProxyServerManager manager = RemoteProxyServerManager.getInstance();
		manager.forceStart();


		RemoteProxy clientProxy = RemoteProxy.createClientProxy(
				new String[]{"com.jonasboner.remoting.proxy.Person"}, // interface(s)
				"com.jonasboner.remoting.proxy.Aperson",  // implementation
				"localhost",       // server IP or hostname
				1099               // server port
		);

		IPerson intstance1 = (IPerson)clientProxy.getInstance();
		intstance1.setName("Gordon");

		System.out.println("this is client proxy generated object Aperson and name is : " + intstance1.getName());


		RemoteProxy proxy = RemoteProxy.createServerProxy(Person.class, "localhost", 1099);
		Object person = proxy.getInstance();
	}
}
