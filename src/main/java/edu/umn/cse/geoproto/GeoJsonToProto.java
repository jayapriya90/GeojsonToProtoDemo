package edu.umn.cse.geoproto;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

public class GeoJsonToProto {
  public static void main(String[] args) {
    String geojson  = "  { \"type\": \"FeatureCollection\",\n" +
      "    \"features\": [\n" +
      "      { \"type\": \"Feature\",\n" +
      "        \"geometry\": {\"type\": \"Point\", \"coordinates\": [102.0, 0.5]}\n" +
      "        },\n" +
      "      { \"type\": \"Feature\",\n" +
      "        \"geometry\": {\"type\": \"Point\", \"coordinates\": [102.0, 0.0]}\n" +
      "        }\n" +
      "       ]\n" +
      "     }";
    GeoProto.FeatureCollectionMsg.Builder builder = GeoProto.FeatureCollectionMsg.newBuilder();
    try {
      JsonFormat.parser().merge(geojson, builder);
      System.out.println("Json size: " + geojson.length());
      byte[] serialized = builder.build().toByteArray();
      System.out.println("Serialized protobuf size: " + serialized.length);
    } catch (InvalidProtocolBufferException e) {
      e.printStackTrace();
    }
  }
}
