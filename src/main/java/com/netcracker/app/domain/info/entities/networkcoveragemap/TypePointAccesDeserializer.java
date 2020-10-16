package com.netcracker.app.domain.info.entities.networkcoveragemap;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


import java.io.IOException;


public class TypePointAccesDeserializer extends JsonDeserializer<TypePointAcces> {

    @Override
    public TypePointAcces deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        if (node == null) {
            return null;
        }

        String text = node.get("typePointAcces").textValue(); // gives "3G" from the request
        if (text == null) {
            return null;
        }

        return TypePointAcces.fromTitle(text);
    }
}

