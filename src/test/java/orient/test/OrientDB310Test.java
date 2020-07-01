package orient.test;

import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory;
import com.tinkerpop.blueprints.impls.orient.OrientVertex;
import org.junit.Test;

import java.util.UUID;

public class OrientDB310Test {

    @Test
    public void createEdgeFromANewVertexTpAnExistingOne() {
        OrientGraphFactory factory = new OrientGraphFactory("remote:localhost:2424/MAPP", "mystudio", "mystudio")
                .setupPool(5, 10);
        OrientGraph g = factory.getTx();
        String targetAppId = "APP1";//APP1 and aAPP2 will fail. APP3 will be successfully committed.
        Vertex target = g.getVertices("LID",targetAppId).iterator().next();
        System.out.println(target.getProperty("ID").toString());

        long currentTime = System.currentTimeMillis();
        OrientVertex v1 = g.addVertex("class:KEYDOK");
        v1.setProperty("ID", UUID.randomUUID().toString());
        v1.setProperty("LID", UUID.randomUUID().toString());
        v1.setProperty("current", true);
        v1.setProperty("insertedOn", currentTime);
        v1.setProperty("version", 1);

        Edge e1 = v1.addEdge("HAS_AS_FAVORITE", target);
        e1.setProperty("insertedOn", currentTime);
        e1.setProperty("isActive", true);
        e1.setProperty("isCurrent", true);
        e1.setProperty("versioning", 1);
        e1.setProperty("since", currentTime);

        g.commit();
        g.shutdown();
        factory.close();
    }
}
