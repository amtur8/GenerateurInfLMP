package ca.ulaval.amtur8.GenerateurInfLMP;

public class Label {

	private String label;

	public Label(String label) {
		this.label = label;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Label) {
			return this.label.equals(((Label) obj).getLabel());
		}
		return false;
	}

	public String getLabel() {
		return label;
	}
}
