////////////////////////////////////////////////
// PATH 1
////////////////////////////////////////////////

Catalog catalog;

public void setUp() {
    catalog = new Catalog();
    catalog.add("Hammer – 10 lb");
    catalog.add("shirt – XL – blue");
    catalog.add("shirt – L – green");
    catalog.add("Halloween candle – orange");
    catalog.add("Halloween candy – gum");
}

public void testSimpleQuery() {
    List result = catalog.itemsMatching("shirt");
    AssertEquals(2, list.size());
}

// An additional test
    Query query = new OrQuery (
		new StringQuery("shirt"),
		new StringQuery("Halloween"));
    list = catalog.itemsMatching(query);
    assertEquals(4, list.size());


////////////////////////////////////////////////
// PATH 2
////////////////////////////////////////////////

    Query query = new Query("shirt");
    List list = query.matchesIn(catalog);
    AssertEquals(2, list.size());

