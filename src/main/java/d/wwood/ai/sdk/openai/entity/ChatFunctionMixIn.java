package d.wwood.ai.sdk.openai.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public abstract class ChatFunctionMixIn {

    @JsonSerialize(using = ChatFunctionParametersSerializerAndDeserializer.Serializer.class)
    @JsonDeserialize(using = ChatFunctionParametersSerializerAndDeserializer.Deserializer.class)
    abstract Class<?> getParametersClass();

}
