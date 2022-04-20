package sockets.classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Packet {
	private final Double[] doubles;
	private final Integer[] ints;
	private final Byte[] bytes;
	private final String[] strings;
	private final Long[] longs;
	private final Float[] floats;
	private final Character[] chars;
	private final Short[] shorts;
	private final Boolean[] booleans;
	private final String name;
	
	public Packet(String name, Double[] doubles, Integer[] ints, Byte[] bytes, String[] strings, Long[] longs, Float[] floats,
			Character[] chars, Short[] shorts, Boolean[] booleans) {
		this.name = name;
		this.doubles = doubles;
		this.ints = ints;
		this.bytes = bytes;
		this.strings = strings;
		this.longs = longs;
		this.floats = floats;
		this.chars = chars;
		this.shorts = shorts;
		this.booleans = booleans;
	}

	public void write(DataOutputStream stream) throws IOException {
		stream.writeUTF(name);
		stream.writeInt(doubles.length);
		for(double d : doubles) stream.writeDouble(d);
		stream.writeInt(ints.length);
		for(int i : ints) stream.writeInt(i);
		stream.writeInt(bytes.length);
		for(byte b : bytes) stream.writeByte(b);
		stream.writeInt(strings.length);
		for(String s : strings) stream.writeUTF(s);
		stream.writeInt(longs.length);
		for(long l : longs) stream.writeLong(l);
		stream.writeInt(floats.length);
		for(float f : floats) stream.writeFloat(f);
		stream.writeInt(chars.length);
		for(char c : chars) stream.writeChar(c);
		stream.writeInt(shorts.length);
		for(short s : shorts) stream.writeShort(s);
		stream.writeInt(booleans.length);
		for(boolean b : booleans) stream.writeBoolean(b);
	}

	public static Packet read(DataInputStream stream) throws IOException {
		String name = stream.readUTF();
		Double[] doubles = new Double[stream.readInt()];
		for(int i = 0; i < doubles.length; i++) {
			doubles[i] = stream.readDouble();
		}
		Integer[] ints = new Integer[stream.readInt()];
		for(int i = 0; i < ints.length; i++) {
			ints[i] = stream.readInt();
		}
		Byte[] bytes = new Byte[stream.readInt()];
		for(int i = 0; i < bytes.length; i++) {
			bytes[i] = stream.readByte();
		}
		String[] strings = new String[stream.readInt()];
		for(int i = 0; i < strings.length; i++) {
			strings[i] = stream.readUTF();
		}
		Long[] longs = new Long[stream.readInt()];
		for(int i = 0; i < longs.length; i++) {
			longs[i] = stream.readLong();
		}
		Float[] floats = new Float[stream.readInt()];
		for(int i = 0; i < floats.length; i++) {
			floats[i] = stream.readFloat();
		}
		Character[] chars = new Character[stream.readInt()];
		for(int i = 0; i < chars.length; i++) {
			chars[i] = stream.readChar();
		}
		Short[] shorts = new Short[stream.readInt()];
		for(int i = 0; i < shorts.length; i++) {
			shorts[i] = stream.readShort();
		}
		Boolean[] booleans = new Boolean[stream.readInt()];
		for(int i = 0; i < booleans.length; i++) {
			booleans[i] = stream.readBoolean();
		}
		return new Packet(name, doubles, ints, bytes, strings, longs, floats, chars, shorts, booleans);
	}
	
	public Double[] getDoubles() {
		return doubles;
	}

	public Integer[] getInts() {
		return ints;
	}

	public Byte[] getBytes() {
		return bytes;
	}

	public String[] getStrings() {
		return strings;
	}

	public Long[] getLongs() {
		return longs;
	}

	public Float[] getFloats() {
		return floats;
	}

	public Character[] getChars() {
		return chars;
	}

	public Short[] getShorts() {
		return shorts;
	}

	public Boolean[] getBooleans() {
		return booleans;
	}
	
	public double getDouble() {
		return doubles[0];
	}
	
	public int getInt() {
		return ints[0];
	}
	
	public byte getByte() {
		return bytes[0];
	}
	
	public String getString() {
		return strings[0];
	}
	
	public long getLong() {
		return longs[0];
	}
	
	public float getFloat() {
		return floats[0];
	}
	
	public char getChar() {
		return chars[0];
	}
	
	public short getShort() {
		return shorts[0];
	}
	
	public boolean getBoolean() {
		return booleans[0];
	}
	
	public String getName() {
		return name;
	}
	
	private static enum Type {
		DOUBLE(0),
		INT(1),
		BYTE(2),
		STRING(3),
		LONG(4),
		FLOAT(5),
		CHAR(6),
		SHORT(7),
		BOOLEAN(8),
		;
		private int value;
		
		private Type(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		
		public static Type assess(int value) {
			return Type.values()[value];
		}
	}
	
	public static class PacketBuilder {
		private Double[] doubles = new Double[0];
		private Integer[] ints = new Integer[0];
		private Byte[] bytes = new Byte[0];
		private String[] strings = new String[0];
		private Long[] longs = new Long[0];
		private Float[] floats = new Float[0];
		private Character[] chars = new Character[0];
		private Short[] shorts = new Short[0];
		private Boolean[] booleans = new Boolean[0];
		private final String name;
		
		public PacketBuilder(String name) {
			this.name = name;
		}
		
		public PacketBuilder Doubles(Double[] doubles) {
			this.doubles = doubles;
			return this;
		}
		
		public PacketBuilder Ints(Integer[] ints) {
			this.ints = ints;
			return this;
		}
		
		public PacketBuilder Bytes(Byte[] bytes) {
			this.bytes = bytes;
			return this;
		}
		
		public PacketBuilder Strings(String[] strings) {
			this.strings = strings;
			return this;
		}
		
		public PacketBuilder Longs(Long[] longs) {
			this.longs = longs;
			return this;
		}
		
		public PacketBuilder Floats(Float[] floats) {
			this.floats = floats;
			return this;
		}
		
		public PacketBuilder Chars(Character[] chars) {
			this.chars = chars;
			return this;
		}
		
		public PacketBuilder Shorts(Short[] shorts) {
			this.shorts = shorts;
			return this;
		}
		
		public PacketBuilder Booleans(Boolean[] booleans) {
			this.booleans = booleans;
			return this;
		} 
		
		public PacketBuilder Double(double d) {
			this.doubles = new Double[1];
			doubles[0] = d;
			return this;
		}
		
		public PacketBuilder Int(int i) {
			this.ints = new Integer[1];
			ints[0] = i;			
			return this;
		}
		
		public PacketBuilder Byte(byte b) {
			this.bytes = new Byte[1];
			bytes[0] = b;
			return this;
		}
		
		public PacketBuilder String(String s) {
			this.strings = new String[1];
			strings[0] = s;
			return this;
		}
		
		public PacketBuilder Long(long l) {
			this.longs = new Long[1];
			longs[0] = l;
			return this;
		}
		
		public PacketBuilder Float(float f) {
			this.floats = new Float[1];
			floats[0] = f;
			return this;
		}
		
		public PacketBuilder Char(char c) {
			this.chars = new Character[1];
			chars[0] = c;
			return this;
		}
		
		public PacketBuilder Short(short s) {
			this.shorts = new Short[1];
			shorts[0] = s;
			return this;
		}
		
		public PacketBuilder Boolean(boolean b) {
			this.booleans = new Boolean[1];
			booleans[0] = b;
			return this;
		}
		
		public Packet Build() {
			return new Packet(name, doubles, ints, bytes, strings, longs, floats, chars, shorts, booleans);
		}
		
	}
}
