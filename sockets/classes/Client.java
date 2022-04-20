package sockets.classes;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
	private String address;
	private int port;
	private PacketEventManager packetEventManager = new PacketEventManager();
	
	public Client(String address, int port) throws Exception {
		this.address = address;
		this.port = port;
	}
	
	public void sendReceivePackets(Packet... packets) {
		try {
			Socket clientSocket = new Socket(address, port); 
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
			DataInputStream dis = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
			for (Packet packet : packets) packet.write(dos);
			dos.flush();
			dos.close();
			packetEventManager.executePackets(dis);
			dis.close();
			clientSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendReceivePacket(Packet packet) {
		try {
			Socket clientSocket = new Socket(address, port); 
			DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
			DataInputStream dis = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
			packet.write(dos);
			dos.flush();
			dos.close();
			packetEventManager.executePackets(dis);
			dis.close();
			clientSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PacketEventManager getPacketEventManager() {
		return packetEventManager;
	}
	
	@Override
	public String toString() {
		return "Client connected at "+address+" on "+port;
	}
}
