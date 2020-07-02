package za.co.neildutoit.jSatisfactorySaveLoader.save;

public class FCompressedChunkHeader {

  public static final long Magic = 0x9E2A83C1;
  public static final int ChunkSize = 131072; // 128 KiB

  private long packageTag;
  private long blockSize;
  private long compressedSize;
  private long uncompressedSize;

  public FCompressedChunkHeader(long packageTag, long blockSize, long compressedSize, long uncompressedSize) {
    this.packageTag = packageTag;
    this.blockSize = blockSize;
    this.compressedSize = compressedSize;
    this.uncompressedSize = uncompressedSize;
  }

  public static long getMagic() {
    return Magic;
  }

  public static int getChunkSize() {
    return ChunkSize;
  }

  public long getPackageTag() {
    return packageTag;
  }

  public void setPackageTag(long packageTag) {
    this.packageTag = packageTag;
  }

  public long getBlockSize() {
    return blockSize;
  }

  public void setBlockSize(long blockSize) {
    this.blockSize = blockSize;
  }

  public long getCompressedSize() {
    return compressedSize;
  }

  public void setCompressedSize(long compressedSize) {
    this.compressedSize = compressedSize;
  }

  public long getUncompressedSize() {
    return uncompressedSize;
  }

  public void setUncompressedSize(long uncompressedSize) {
    this.uncompressedSize = uncompressedSize;
  }
}
