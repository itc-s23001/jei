enum Connection {OFFLINE, ONLINE}

class Q22 {
  public static void main(String[] args) {
   Connection s = OFFLINE;
   if (s == Connection.OFFLINE) {
      s = Connection.ONLINE;
  }
  System.out.print(s);
 }
} 
