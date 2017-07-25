package Logic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Logic {

	List<Node> nodeSet;

	public List<Node> createNodes(int number) {

		nodeSet = new ArrayList<Node>();

		for (int i = 1; i <= number; i++) {

			nodeSet.add(new Node(i, null));
		}

		return nodeSet;
	}

	public List<Node> getNodeList() {
		return nodeSet;
	}

	public void union(int nodeId1, int nodeId2) {

		// boolean isSuccessfull=false;
		if (nodeSet != null) {
			Node node1 = nodeSet.get(nodeId1 - 1);
			Node node2 = nodeSet.get(nodeId2 - 1);

			if (node1.setId != null) {
				if (node2.setId != null) {
					if (node1.setId != node2.setId) {
						node1.setId.addAll(node2.setId);

					}

				} else {
					node1.setId.add(node2);
					node2.setId=node1.setId;
				}

			} else if (node2.setId != null) {
				node2.setId.add(node1);
				node1.setId=node2.setId;

			} else {
				node1.setId = new HashSet<Node>();
				node1.setId.add(node1);
				node1.setId.add(node2);
				node2.setId=node1.setId;
			}

			// isSuccessfull=true;
		}
	}
	// return isSuccessfull;

	public boolean isConnected(int nodeId1, int nodeId2) {
		Node node1 = nodeSet.get(nodeId1 - 1);
		Node node2 = nodeSet.get(nodeId2 - 1);

		//if (nodeSet.get(node1 - 1).setId == nodeSet.get(node2 - 1).setId) {
		
		if((node1.setId!=null && node2.setId!=null)&&(node1.setId==node2.setId|| node1.setId.contains(node2)||node2.setId.contains(node1))){
			return true;
		}
		return false;

	}

}
