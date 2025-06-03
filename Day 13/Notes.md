## File Handling
package : java.io.

Syntax: File f = new File("D:/Myfolder/fole.txt");

### Methods
1. f.exists() -> boolean
2. f.getName() -> Returns the name of the file or directory
3. f.length() -> Returns the length of the file
4. f.getAbsolutePath() -> Returns the absolute pathname string
5. f.delete() -> Deletes the file or directory 

### Streams
- Character Stream -> text, etc...
- Byte Stream -> videos, images, etc...

| Feature        | Character Stream               | Byte Stream                                |
| -------------- | ------------------------------ | ------------------------------------------ |
| Purpose        | Text files                     | Binary files                               |
| Data Type      | Characters (`char`)            | Bytes (`byte`)                             |
| Examples       | `.txt`, `.csv`, `.xml`         | `.jpg`, `.mp4`, `.pdf`                     |
| Input Classes  | `FileReader`, `BufferedReader` | `FileInputStream`, `BufferedInputStream`   |
| Output Classes | `FileWriter`, `BufferedWriter` | `FileOutputStream`, `BufferedOutputStream` |

### ByteStream Class
1. FileInputStream
2. FileOutputStream
3. BufferedInputStream
4. BufferedOutputStream
5. ByteArrayInputStream
6. ByteArrayOutputStream
7. DataInputStream
8. DataOutputStream
9. PrintStream

### CharacterStream Class
1. FileReader
2. FileWriter
3. BufferReader
4. BufferWriter
5. PrintWritter
6. charArrayWritter
7. charArrayReader
8. StringReader
9. StringWritter

### Serialization
Serialization in Java is the process of converting an object into a byte stream, so it can be:
- Saved to a file,
- Sent over a network,
- Stored in memory for later reconstruction (deserialization).

#### Classes :
1. ObjectOutputStream
2. ObjectInputStream