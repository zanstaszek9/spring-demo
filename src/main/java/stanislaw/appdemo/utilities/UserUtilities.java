package stanislaw.appdemo.utilities;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import stanislaw.appdemo.user.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserUtilities {

    public static String getLoggedUser() {
        String username = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(!(auth instanceof AnonymousAuthenticationToken))
            username = auth.getName();

        return username;
    }

    public static List<User> userDataLoader(File file){
        List<User> userList = new ArrayList<User>();

        try{
            NodeList nList = getNodeListFromDocBuildFactoryWithElemTag(file,"user");
            setUsersListFromNodeList(userList, nList);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return  userList;
    }

    private static NodeList getNodeListFromDocBuildFactoryWithElemTag(File file, String tagname)
            throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName(tagname);

        return nList;
    }

    private static void setUsersListFromNodeList(List userList, NodeList nList){
        for (int i = 0; i < nList.getLength(); i++ ) {
            Node node = nList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element e = (Element) node;
                User u = new User();
                setUserFieldsFromElement(u, e);
                userList.add(u);
            }
        }
    }

    private static void setUserFieldsFromElement(User user, Element e){
        user.setEmail(e.getElementsByTagName("email").item(0).getTextContent());
        user.setPassword(e.getElementsByTagName("password").item(0).getTextContent());
        user.setName(e.getElementsByTagName("name").item(0).getTextContent());
        user.setLastName(e.getElementsByTagName("lastname").item(0).getTextContent());
        user.setActive(Integer.valueOf(e.getElementsByTagName("active").item(0).getTextContent()));
        user.setNrRole(Integer.valueOf(e.getElementsByTagName("nrroli").item(0).getTextContent()));
    }

}
