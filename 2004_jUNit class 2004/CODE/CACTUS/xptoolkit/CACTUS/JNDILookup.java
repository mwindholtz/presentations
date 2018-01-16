/*
 * JNDILookup.java
 *
 * Created on August 5, 2001, 11:56 PM
 */

package xptoolkit.cactus;
import javax.naming.InitialContext;
import javax.sql.XADataSource;
import javax.sql.XAConnection;
import java.sql.Connection;

/**
 *
 * @author  nick
 * @version 
 */
public class JNDILookup {

    /** Creates new JNDILookup */
    public static XAConnection connectionLookup() throws Exception {
        InitialContext ctx = new InitialContext();
        XADataSource src = 
            (XADataSource)ctx.lookup("java/comp/env/webDatabase");
        return src.getXAConnection();
    }

}
