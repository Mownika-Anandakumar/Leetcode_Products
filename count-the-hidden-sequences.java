  public int numberOfArrays(int[] differences, int lower, int upper) {
    long[] prefix = new long[differences.length + 1];
    for (int i = 0; i < differences.length; ++i)
      prefix[i + 1] += prefix[i] + differences[i];
    final long mx = Arrays.stream(prefix).max().getAsLong();
    final long mn = Arrays.stream(prefix).min().getAsLong();
    return (int) Math.max(0L, (upper - lower) - (mx - mn) + 1);
  }
}
