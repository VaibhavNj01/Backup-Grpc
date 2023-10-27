// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PatientService.proto

package com.ca.patient;

/**
 * Protobuf type {@code com.ca.patient.GetAppointmentByIdRequest}
 */
public final class GetAppointmentByIdRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.ca.patient.GetAppointmentByIdRequest)
    GetAppointmentByIdRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetAppointmentByIdRequest.newBuilder() to construct.
  private GetAppointmentByIdRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetAppointmentByIdRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetAppointmentByIdRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.ca.patient.PatientServiceOuterClass.internal_static_com_ca_patient_GetAppointmentByIdRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.ca.patient.PatientServiceOuterClass.internal_static_com_ca_patient_GetAppointmentByIdRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.ca.patient.GetAppointmentByIdRequest.class, com.ca.patient.GetAppointmentByIdRequest.Builder.class);
  }

  public static final int APPOINTMENTID_FIELD_NUMBER = 1;
  private long appointmentId_ = 0L;
  /**
   * <code>int64 appointmentId = 1;</code>
   * @return The appointmentId.
   */
  @java.lang.Override
  public long getAppointmentId() {
    return appointmentId_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (appointmentId_ != 0L) {
      output.writeInt64(1, appointmentId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (appointmentId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, appointmentId_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.ca.patient.GetAppointmentByIdRequest)) {
      return super.equals(obj);
    }
    com.ca.patient.GetAppointmentByIdRequest other = (com.ca.patient.GetAppointmentByIdRequest) obj;

    if (getAppointmentId()
        != other.getAppointmentId()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + APPOINTMENTID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getAppointmentId());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.ca.patient.GetAppointmentByIdRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.ca.patient.GetAppointmentByIdRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.ca.patient.GetAppointmentByIdRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.ca.patient.GetAppointmentByIdRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.ca.patient.GetAppointmentByIdRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.ca.patient.GetAppointmentByIdRequest)
      com.ca.patient.GetAppointmentByIdRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.ca.patient.PatientServiceOuterClass.internal_static_com_ca_patient_GetAppointmentByIdRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.ca.patient.PatientServiceOuterClass.internal_static_com_ca_patient_GetAppointmentByIdRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.ca.patient.GetAppointmentByIdRequest.class, com.ca.patient.GetAppointmentByIdRequest.Builder.class);
    }

    // Construct using com.ca.patient.GetAppointmentByIdRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      appointmentId_ = 0L;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.ca.patient.PatientServiceOuterClass.internal_static_com_ca_patient_GetAppointmentByIdRequest_descriptor;
    }

    @java.lang.Override
    public com.ca.patient.GetAppointmentByIdRequest getDefaultInstanceForType() {
      return com.ca.patient.GetAppointmentByIdRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.ca.patient.GetAppointmentByIdRequest build() {
      com.ca.patient.GetAppointmentByIdRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.ca.patient.GetAppointmentByIdRequest buildPartial() {
      com.ca.patient.GetAppointmentByIdRequest result = new com.ca.patient.GetAppointmentByIdRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.ca.patient.GetAppointmentByIdRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.appointmentId_ = appointmentId_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.ca.patient.GetAppointmentByIdRequest) {
        return mergeFrom((com.ca.patient.GetAppointmentByIdRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.ca.patient.GetAppointmentByIdRequest other) {
      if (other == com.ca.patient.GetAppointmentByIdRequest.getDefaultInstance()) return this;
      if (other.getAppointmentId() != 0L) {
        setAppointmentId(other.getAppointmentId());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              appointmentId_ = input.readInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private long appointmentId_ ;
    /**
     * <code>int64 appointmentId = 1;</code>
     * @return The appointmentId.
     */
    @java.lang.Override
    public long getAppointmentId() {
      return appointmentId_;
    }
    /**
     * <code>int64 appointmentId = 1;</code>
     * @param value The appointmentId to set.
     * @return This builder for chaining.
     */
    public Builder setAppointmentId(long value) {

      appointmentId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int64 appointmentId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAppointmentId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      appointmentId_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.ca.patient.GetAppointmentByIdRequest)
  }

  // @@protoc_insertion_point(class_scope:com.ca.patient.GetAppointmentByIdRequest)
  private static final com.ca.patient.GetAppointmentByIdRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.ca.patient.GetAppointmentByIdRequest();
  }

  public static com.ca.patient.GetAppointmentByIdRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetAppointmentByIdRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetAppointmentByIdRequest>() {
    @java.lang.Override
    public GetAppointmentByIdRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<GetAppointmentByIdRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetAppointmentByIdRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.ca.patient.GetAppointmentByIdRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

