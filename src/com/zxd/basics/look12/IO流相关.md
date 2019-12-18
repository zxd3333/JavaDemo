## IO流
流的本质是数据传输，IO流就是用来处理设备间的数据传输问题的
### 分类
* 按数据流向分类
    * 输入流 -> 读数据
    * 输出流 -> 写数据
* 按数据操作类型分类
    * 字节流
        * 字节输入流(InputStream)
            * FileInputStream
            * BufferedInputStream
        * 字节输出流(OutputStream)
            * FileOutputStream
            * BufferedOutputStream
    * 字符流
        * 字符输入流(Reader)
            * FileReader
            * BufferedReader
            * InputStreamReader(转换流)
        * 字符输出流(Writer)
            * FileWriter
            * BufferedWriter
            * OutputStreamWriter(转换流)
### 字符流出现的原因
由于编码问题，字节流操作中文不是特别方便，所以提供了字符流  
文件中即使有中文，字符流也能复制成功，是因为底层有相关操作