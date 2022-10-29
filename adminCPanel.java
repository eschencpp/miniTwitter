package miniTwitter;

/**
 * adminCPanel
 */
public class adminCPanel {

    private static adminCPanel acp = null;

    private adminCPanel()
    {
        
    }
    
    public static adminCPanel getInstance()
    {
        if (acp == null)
        acp = new adminCPanel();
  
        return acp;
    }


}