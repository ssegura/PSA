package psa.model;

import java.util.HashMap;
import java.util.Map;

public class ContactRepository implements IContactRepository {

	private Map<String,Contact> contacts;
	private static ContactRepository instance=null;
	private int index=0;			// Index to create contacts' identifiers.
	
	public static ContactRepository getInstance() {
		
		if (instance==null) {
			instance = new ContactRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		contacts = new HashMap<String,Contact>();
		addContact("Manuel Durán", "699045872");
		addContact("Daniel López", "954822754");
		addContact("Ana María Calleja", "362578966");
	}

	@Override
	public Map<String,Contact> getContacts() {
		return contacts;
	}

	@Override
	public void updateContact(Contact c) {
		contacts.put(c.getId(), c);
	}

	@Override
	public Contact getContact(String id) {
		return contacts.get(id);
	}

	@Override
	public Contact addContact(String name, String telephone) {
		// Create random id
		String id = "c" + index;
		Contact c = new Contact(id, name, telephone);
		contacts.put(id,c);
		index++;
		return c;
	}

	@Override
	public void deleteContact(String id) {
		contacts.remove(id);
	}

}
