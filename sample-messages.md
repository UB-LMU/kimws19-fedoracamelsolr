# CREATE

15:22:36.661 [Camel (camel-1) thread #2 - JmsConsumer[fedora]] INFO route1 - 
```(javascript)
{
   "wasAttributedTo" : [
      {
         "name" : "fedoraAdmin",
         "type" : "http://www.w3.org/ns/prov#Person"
      },
      {
         "type" : "http://www.w3.org/ns/prov#SoftwareAgent",
         "name" : "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0"
      }
   ],
   "wasGeneratedBy" : {
      "atTime" : "2019-03-14T14:22:36.516Z",
      "type" : [
         "http://fedora.info/definitions/v4/event#ResourceCreation",
         "http://fedora.info/definitions/v4/event#ResourceModification",
         "http://www.w3.org/ns/prov#Activity"
      ],
      "identifier" : "urn:uuid:ab4da075-bb94-410c-8733-a49218656fb0"
   },
   "type" : [
      "http://www.w3.org/ns/ldp#Container",
      "http://fedora.info/definitions/v4/repository#Resource",
      "http://fedora.info/definitions/v4/repository#Container",
      "http://www.w3.org/ns/ldp#RDFSource",
      "http://www.w3.org/ns/prov#Entity"
   ],
   "isPartOf" : "http://localhost:8080/fcrepo/rest",
   "id" : "http://localhost:8080/fcrepo/rest/my-container",
   "@context" : {
      "identifier" : {
         "@id" : "dcterms:identifier",
         "@type" : "@id"
      },
      "prov" : "http://www.w3.org/ns/prov#",
      "id" : "@id",
      "atTime" : {
         "@id" : "prov:atTime",
         "@type" : "xsd:dateTime"
      },
      "xsd" : "http://www.w3.org/2001/XMLSchema#",
      "foaf" : "http://xmlns.com/foaf/0.1/",
      "name" : {
         "@type" : "xsd:string",
         "@id" : "foaf:name"
      },
      "wasGeneratedBy" : {
         "@type" : "@id",
         "@id" : "prov:wasGeneratedBy"
      },
      "type" : "@type",
      "wasAttributedTo" : {
         "@id" : "prov:wasAttributedTo",
         "@type" : "@id"
      },
      "isPartOf" : {
         "@id" : "dcterms:isPartOf",
         "@type" : "@id"
      },
      "dcterms" : "http://purl.org/dc/terms/"
   }
}
```

15:22:36.714 [Camel (camel-1) thread #2 - JmsConsumer[fedora]] INFO route1 - 
```(javascript)
{
   "type" : [
      "http://www.w3.org/ns/ldp#Container",
      "http://fedora.info/definitions/v4/repository#Resource",
      "http://fedora.info/definitions/v4/repository#Container",
      "http://www.w3.org/ns/ldp#RDFSource",
      "http://fedora.info/definitions/v4/repository#RepositoryRoot",
      "http://www.w3.org/ns/ldp#BasicContainer",
      "http://www.w3.org/ns/prov#Entity"
   ],
   "id" : "http://localhost:8080/fcrepo/rest",
   "wasGeneratedBy" : {
      "identifier" : "urn:uuid:83e792ff-384f-4930-ab4b-7c393db60f79",
      "atTime" : "2019-03-14T14:22:36.516Z",
      "type" : [
         "http://fedora.info/definitions/v4/event#ResourceModification",
         "http://www.w3.org/ns/prov#Activity"
      ]
   },
   "wasAttributedTo" : [
      {
         "name" : "fedoraAdmin",
         "type" : "http://www.w3.org/ns/prov#Person"
      },
      {
         "type" : "http://www.w3.org/ns/prov#SoftwareAgent",
         "name" : "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0"
      }
   ],
   "isPartOf" : "http://localhost:8080/fcrepo/rest",
   "@context" : {
      "xsd" : "http://www.w3.org/2001/XMLSchema#",
      "type" : "@type",
      "atTime" : {
         "@type" : "xsd:dateTime",
         "@id" : "prov:atTime"
      },
      "wasGeneratedBy" : {
         "@id" : "prov:wasGeneratedBy",
         "@type" : "@id"
      },
      "prov" : "http://www.w3.org/ns/prov#",
      "id" : "@id",
      "wasAttributedTo" : {
         "@type" : "@id",
         "@id" : "prov:wasAttributedTo"
      },
      "dcterms" : "http://purl.org/dc/terms/",
      "name" : {
         "@type" : "xsd:string",
         "@id" : "foaf:name"
      },
      "isPartOf" : {
         "@id" : "dcterms:isPartOf",
         "@type" : "@id"
      },
      "identifier" : {
         "@type" : "@id",
         "@id" : "dcterms:identifier"
      },
      "foaf" : "http://xmlns.com/foaf/0.1/"
   }
}
```

# DELETE

2019-03-14 15:26:28 | INFO  | [Camel (camel-1) thread #2 - JmsConsumer[fedora]] route1:159 - 
```(javascript)
{
   "wasGeneratedBy" : {
      "type" : [
         "http://fedora.info/definitions/v4/event#ResourceDeletion",
         "http://www.w3.org/ns/prov#Activity"
      ],
      "atTime" : "2019-03-14T14:26:27.909Z",
      "identifier" : "urn:uuid:325e3643-c375-412e-8667-a8b802c5c69e"
   },
   "isPartOf" : "http://localhost:8080/fcrepo/rest",
   "wasAttributedTo" : [
      {
         "name" : "fedoraAdmin",
         "type" : "http://www.w3.org/ns/prov#Person"
      },
      {
         "type" : "http://www.w3.org/ns/prov#SoftwareAgent",
         "name" : "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0"
      }
   ],
   "@context" : {
      "wasAttributedTo" : {
         "@type" : "@id",
         "@id" : "prov:wasAttributedTo"
      },
      "type" : "@type",
      "identifier" : {
         "@id" : "dcterms:identifier",
         "@type" : "@id"
      },
      "xsd" : "http://www.w3.org/2001/XMLSchema#",
      "prov" : "http://www.w3.org/ns/prov#",
      "wasGeneratedBy" : {
         "@id" : "prov:wasGeneratedBy",
         "@type" : "@id"
      },
      "dcterms" : "http://purl.org/dc/terms/",
      "atTime" : {
         "@type" : "xsd:dateTime",
         "@id" : "prov:atTime"
      },
      "foaf" : "http://xmlns.com/foaf/0.1/",
      "id" : "@id",
      "name" : {
         "@type" : "xsd:string",
         "@id" : "foaf:name"
      },
      "isPartOf" : {
         "@id" : "dcterms:isPartOf",
         "@type" : "@id"
      }
   },
   "id" : "http://localhost:8080/fcrepo/rest/my-container",
   "type" : [
      "http://www.w3.org/ns/ldp#Container",
      "http://fedora.info/definitions/v4/repository#Resource",
      "http://fedora.info/definitions/v4/repository#Container",
      "http://www.w3.org/ns/ldp#RDFSource",
      "http://www.w3.org/ns/prov#Entity"
   ]
}
```

2019-03-14 15:26:28 | INFO  | [Camel (camel-1) thread #2 - JmsConsumer[fedora]] route1:159 - 
```(javascript)
{
   "wasAttributedTo" : [
      {
         "type" : "http://www.w3.org/ns/prov#Person",
         "name" : "fedoraAdmin"
      },
      {
         "type" : "http://www.w3.org/ns/prov#SoftwareAgent",
         "name" : "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0"
      }
   ],
   "wasGeneratedBy" : {
      "identifier" : "urn:uuid:72a9a020-f217-428a-803e-abcf9baf08ae",
      "type" : [
         "http://fedora.info/definitions/v4/event#ResourceModification",
         "http://www.w3.org/ns/prov#Activity"
      ],
      "atTime" : "2019-03-14T14:26:27.909Z"
   },
   "isPartOf" : "http://localhost:8080/fcrepo/rest",
   "type" : [
      "http://www.w3.org/ns/ldp#Container",
      "http://fedora.info/definitions/v4/repository#Resource",
      "http://fedora.info/definitions/v4/repository#Container",
      "http://www.w3.org/ns/ldp#RDFSource",
      "http://fedora.info/definitions/v4/repository#RepositoryRoot",
      "http://www.w3.org/ns/ldp#BasicContainer",
      "http://www.w3.org/ns/prov#Entity"
   ],
   "@context" : {
      "prov" : "http://www.w3.org/ns/prov#",
      "wasGeneratedBy" : {
         "@id" : "prov:wasGeneratedBy",
         "@type" : "@id"
      },
      "id" : "@id",
      "identifier" : {
         "@id" : "dcterms:identifier",
         "@type" : "@id"
      },
      "xsd" : "http://www.w3.org/2001/XMLSchema#",
      "atTime" : {
         "@type" : "xsd:dateTime",
         "@id" : "prov:atTime"
      },
      "wasAttributedTo" : {
         "@type" : "@id",
         "@id" : "prov:wasAttributedTo"
      },
      "isPartOf" : {
         "@type" : "@id",
         "@id" : "dcterms:isPartOf"
      },
      "name" : {
         "@id" : "foaf:name",
         "@type" : "xsd:string"
      },
      "type" : "@type",
      "foaf" : "http://xmlns.com/foaf/0.1/",
      "dcterms" : "http://purl.org/dc/terms/"
   },
   "id" : "http://localhost:8080/fcrepo/rest"
}
```


# ADD BINARY

2019-03-14 15:29:44 | INFO  | [Camel (camel-1) thread #2 - JmsConsumer[fedora]] consume-jms-messages:159 - 
```(javascript)
{
   "@context" : {
      "wasGeneratedBy" : {
         "@type" : "@id",
         "@id" : "prov:wasGeneratedBy"
      },
      "wasAttributedTo" : {
         "@id" : "prov:wasAttributedTo",
         "@type" : "@id"
      },
      "dcterms" : "http://purl.org/dc/terms/",
      "id" : "@id",
      "type" : "@type",
      "identifier" : {
         "@type" : "@id",
         "@id" : "dcterms:identifier"
      },
      "name" : {
         "@type" : "xsd:string",
         "@id" : "foaf:name"
      },
      "atTime" : {
         "@type" : "xsd:dateTime",
         "@id" : "prov:atTime"
      },
      "foaf" : "http://xmlns.com/foaf/0.1/",
      "xsd" : "http://www.w3.org/2001/XMLSchema#",
      "isPartOf" : {
         "@type" : "@id",
         "@id" : "dcterms:isPartOf"
      },
      "prov" : "http://www.w3.org/ns/prov#"
   },
   "wasAttributedTo" : [
      {
         "type" : "http://www.w3.org/ns/prov#Person",
         "name" : "fedoraAdmin"
      },
      {
         "type" : "http://www.w3.org/ns/prov#SoftwareAgent",
         "name" : "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0"
      }
   ],
   "wasGeneratedBy" : {
      "type" : [
         "http://fedora.info/definitions/v4/event#ResourceCreation",
         "http://fedora.info/definitions/v4/event#ResourceModification",
         "http://www.w3.org/ns/prov#Activity"
      ],
      "identifier" : "urn:uuid:45761391-5f5e-45f2-80f0-cf45b1647ce0",
      "atTime" : "2019-03-14T14:29:44.684Z"
   },
   "isPartOf" : "http://localhost:8080/fcrepo/rest",
   "type" : [
      "http://fedora.info/definitions/v4/repository#Binary",
      "http://www.w3.org/ns/ldp#NonRDFSource",
      "http://fedora.info/definitions/v4/repository#Resource",
      "http://fedora.info/definitions/v4/repository#NonRdfSourceDescription",
      "http://www.w3.org/ns/prov#Entity"
   ],
   "id" : "http://localhost:8080/fcrepo/rest/a9/2c/53/c7/a92c53c7-6c04-43c1-98b9-db99a7376190"
}
```

2019-03-14 15:29:44 | INFO  | [Camel (camel-1) thread #2 - JmsConsumer[fedora]] consume-jms-messages:159 - 
```(javascript)
{
   "@context" : {
      "wasGeneratedBy" : {
         "@id" : "prov:wasGeneratedBy",
         "@type" : "@id"
      },
      "dcterms" : "http://purl.org/dc/terms/",
      "atTime" : {
         "@type" : "xsd:dateTime",
         "@id" : "prov:atTime"
      },
      "type" : "@type",
      "id" : "@id",
      "xsd" : "http://www.w3.org/2001/XMLSchema#",
      "prov" : "http://www.w3.org/ns/prov#",
      "identifier" : {
         "@id" : "dcterms:identifier",
         "@type" : "@id"
      },
      "name" : {
         "@type" : "xsd:string",
         "@id" : "foaf:name"
      },
      "foaf" : "http://xmlns.com/foaf/0.1/",
      "wasAttributedTo" : {
         "@id" : "prov:wasAttributedTo",
         "@type" : "@id"
      },
      "isPartOf" : {
         "@id" : "dcterms:isPartOf",
         "@type" : "@id"
      }
   },
   "wasAttributedTo" : [
      {
         "name" : "fedoraAdmin",
         "type" : "http://www.w3.org/ns/prov#Person"
      },
      {
         "type" : "http://www.w3.org/ns/prov#SoftwareAgent",
         "name" : "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:65.0) Gecko/20100101 Firefox/65.0"
      }
   ],
   "wasGeneratedBy" : {
      "type" : [
         "http://fedora.info/definitions/v4/event#ResourceModification",
         "http://www.w3.org/ns/prov#Activity"
      ],
      "atTime" : "2019-03-14T14:29:44.684Z",
      "identifier" : "urn:uuid:9f81b072-8cce-458b-bb3a-f9b8f516a7de"
   },
   "type" : [
      "http://www.w3.org/ns/ldp#Container",
      "http://fedora.info/definitions/v4/repository#Resource",
      "http://fedora.info/definitions/v4/repository#Container",
      "http://www.w3.org/ns/ldp#RDFSource",
      "http://fedora.info/definitions/v4/repository#RepositoryRoot",
      "http://www.w3.org/ns/ldp#BasicContainer",
      "http://www.w3.org/ns/prov#Entity"
   ],
   "id" : "http://localhost:8080/fcrepo/rest",
   "isPartOf" : "http://localhost:8080/fcrepo/rest"
}
```

