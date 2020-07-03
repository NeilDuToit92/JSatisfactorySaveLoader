package za.co.neildutoit.jSatisfactorySaveLoader.save.custom;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.control.Vector3;
import za.co.neildutoit.jSatisfactorySaveLoader.control.Vector4;
import za.co.neildutoit.jSatisfactorySaveLoader.save.FCompressedChunkHeader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.FCompressedChunkInfo;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/**
 * A java class that is capable for parsing .net BinaryWriter encoded files.
 * Some methods are not implemented as I have not need for them. Enjoy!
 *
 * @author robbiev
 * fork @author jaymarvels
 */
public class BinaryReader extends FilterInputStream {

  public BinaryReader(InputStream in) {
    super(in);
    setPosition(0);
  }

  /**
   * Reads a 4-byte signed integer from the current stream and advances the current position of the stream by four bytes.
   *
   * @return
   * @throws IOException
   */
  public int readInt32() throws IOException {
//    readBytes already does this incrementPosition(4);
    return ByteBuffer.wrap(this.readBytes(4))
        .order(ByteOrder.LITTLE_ENDIAN)
        .getInt()
        ;

  }

  /**
   * Reads a 8-byte signed integer from the current stream and advances the current position of the stream by eight bytes.
   *
   * @return
   * @throws IOException
   */
  public long readInt64() throws IOException {
    //incrementPosition(8);
    return ByteBuffer.wrap(this.readBytes(8))
        .order(ByteOrder.LITTLE_ENDIAN)
        .getLong()
        ;

  }

  /**
   * Reads a 4-byte unsigned integer from the current stream and advances the position of the stream by four bytes. Returns a long as java does not have the means to have unsigned values.
   *
   * @return
   * @throws IOException
   */
  public long readUInt32() throws IOException {
//    incrementPosition(4);
    return this.readInt32() & 0xFFFFFFFFL;
  }

  /**
   * Reads a 2-byte signed integer from the current stream and advances the current position of the stream by two bytes. Returns a 32-bit int as there are not 16-bit ints in java.
   *
   * @return
   * @throws IOException
   */
  public int readInt16() throws IOException {
//    incrementPosition(2);
    return ByteBuffer.wrap(this.readBytes(2))
        .order(ByteOrder.LITTLE_ENDIAN)
        .getShort()
        ;
  }

  /**
   * Reads a 2-byte unsigned integer from the current stream using little-endian encoding and advances the position of the stream by two bytes. Returns a 32-bit int as there are not 16-bit ints in java.
   *
   * @return
   * @throws IOException
   */
  public int readUInt16() throws IOException {
//    incrementPosition(2);
    return this.readInt16() & 0xFFFF;
  }

  /**
   * Reads a 2-byte signed integer from the current stream and advances the current position of the stream by two bytes. Returns a 32-bit int as there are not 16-bit ints in java.
   *
   * @return
   * @throws IOException
   */
  public short readShort() throws IOException {
//    incrementPosition(2);
    return ByteBuffer.wrap(this.readBytes(2))
        .order(ByteOrder.LITTLE_ENDIAN)
        .getShort()
        ;
  }

  /**
   * Reads a string from the current stream. The string is prefixed with the length, encoded as an integer seven bits at a time.
   *
   * @return
   * @throws IOException
   */
  public String readString() throws IOException {
//    incrementPosition(this.getStringLength());
    return new String(this.readBytes(this.getStringLength()));
  }

  /**
   * Reads a Boolean value from the current stream and advances the current position of the stream by one byte.
   *
   * @return
   * @throws IOException
   */
  public boolean readBoolean() throws IOException {
//    incrementPosition(1);
    return this.readBytes(1)[0] != 0;
  }

  /**
   * Reads a 4-byte floating point value from the current stream and advances the current position of the stream by four bytes.
   *
   * @return
   * @throws IOException
   */
  public float readSingle() throws IOException {
//    incrementPosition(4);
    return ByteBuffer.wrap(this.readBytes(4))
        .order(ByteOrder.LITTLE_ENDIAN)
        .getFloat()
        ;
  }

  /**
   * Source: https://github.com/vrecan/Thaw-Giant/blob/master/src/main/java/com/vreco/thawgiant/BinaryUtil.java
   * Binary files are encoded with a variable length prefix that tells you
   * the size of the string. The prefix is encoded in a 7bit format where the
   * 8th bit tells you if you should continue. If the 8th bit is set it means
   * you need to read the next byte.
   *
   * @param bytes
   * @return
   * @throws IOException
   */
  private int getStringLength() throws IOException {
    int count = 0;
    int shift = 0;
    boolean more = true;
    while (more) {
      byte b = (byte) this.read();
      count |= (b & 0x7F) << shift;
      shift += 7;
      if ((b & 0x80) == 0) {
        more = false;
      }
    }
    return count;
  }

  /**
   * Read a single byte.
   *
   * @return
   * @throws IOException
   */
  public byte readByte() throws IOException {
//    incrementPosition(1);
    return ByteBuffer.wrap(this.readBytes(1))
        .order(ByteOrder.LITTLE_ENDIAN)
        .get()
        ;
  }


  /**
   * Read an arbitrary number of bytes.
   *
   * @param length
   * @return
   * @throws IOException
   */
  public byte[] readBytes(int length) throws IOException {
    byte[] bytes = new byte[length];
    this.read(bytes);
    incrementPosition(length);
    return bytes;
  }

  private void incrementPosition(int increment) {
    setPosition(getPosition() + increment);
  }

  private void decrementPosition(int decrement) {
    setPosition(getPosition() - decrement);
  }

  private int position;

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public String readCharArray() throws IOException {
    int count = readInt32();
    //readInt32 increments position incorrectly when compared to C#
//    decrementPosition(2);
    if (count >= 0) {
      byte[] bytes = readBytes(count);
      return new String(bytes, StandardCharsets.UTF_8);
    } else {
      byte[] bytes = readBytes(count * -2);
      return new String(bytes, StandardCharsets.UTF_8);
    }
  }

  public Vector4 readVector4() throws IOException {
    float x = readSingle();
    float y = readSingle();
    float z = readSingle();
    float w = readSingle();
    return new Vector4(x, y, z, w);
  }

  public Vector3 readVector3() throws IOException {
    float x = readSingle();
    float y = readSingle();
    float z = readSingle();

    return new Vector3(x, y, z);
  }

  /**
   * Read an UE4 FCompressedChunkHeader
   *
   * @return
   */
  public FCompressedChunkHeader readCompressedChunkHeader() throws IOException {
    long packageTag = readInt64();
    long blockSize = readInt64();
    long compressedSize = readInt64();
    long uncompressedSize = readInt64();

    return new FCompressedChunkHeader(packageTag, blockSize, compressedSize, uncompressedSize);
  }

  /**
   * Read an UE4 FCompressedChunkInfo
   *
   * @return
   */
  public FCompressedChunkInfo readCompressedChunkInfo() throws IOException {
    long compressedSize = readInt64();
    long uncompressedSize = readInt64();
    return new FCompressedChunkInfo(compressedSize, uncompressedSize);
  }

  /**
   * Read a UE4 Object Reference (Level, Path)
   *
   * @return
   */
  public ObjectReference readObjectReference() throws IOException {
    String level = readCharArray();
    String path = readCharArray();
    return new ObjectReference(level, path);
  }
}