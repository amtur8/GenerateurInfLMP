package amtur8.GenerateurInfLMP;

public class Label {

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Label){
			return this.label.equals(((Label)obj).getLabel());
		}
		return false;
	}

	private String label;

	public Label(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
