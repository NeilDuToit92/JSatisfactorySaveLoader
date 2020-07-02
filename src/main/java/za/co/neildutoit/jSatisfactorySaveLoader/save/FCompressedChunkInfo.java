package za.co.neildutoit.jSatisfactorySaveLoader.save;

public class FCompressedChunkInfo {
  private long compressedSize;
  private long uncompressedSize;

  public FCompressedChunkInfo(long compressedSize, long uncompressedSize) {
    this.compressedSize = compressedSize;
    this.uncompressedSize = uncompressedSize;
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
