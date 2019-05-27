package entities;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String login;
    private String password;
    private Map<String, Integer> voices = new HashMap<>();

    public User() {
        voices.put("deni", 0);
        voices.put("snow", 0);
        voices.put("vader", 0);
        voices.put("angel", 0);
        voices.put("demon", 0);
        voices.put("potato", 0);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Integer> getVoices() { // just for reading
        return new HashMap<>(voices);
    }

    // Add voice to the map
    public synchronized void addVoice(String ... voices) {
        if(voices!= null){
            for(String voice :voices){
                if (voice != null && this.voices.containsKey(voice)) {
                    Integer voiceCount = this.voices.get(voice);
                    this.voices.put(voice, ++voiceCount);
                }
            }
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        String s = login + " ";
        for (String key : voices.keySet()) {
            s = s + key + ":" + voices.get(key) + " ";
        }
        return s;
    }


}
