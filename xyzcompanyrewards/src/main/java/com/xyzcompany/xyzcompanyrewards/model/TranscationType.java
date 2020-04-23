package com.xyzcompany.xyzcompanyrewards.model;

public enum TranscationType {
	    TOTAL("1"), DETAIL("2");
	
	public final String label;
	 
    private TranscationType(String label) {
        this.label = label;
    }
    
    public static TranscationType valueOfLabel(String label) {
        for (TranscationType e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }
}
