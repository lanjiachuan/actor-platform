package im.actor.model.api.rpc;
/*
 *  Generated by the Actor API Scheme generator.  DO NOT EDIT!
 */

import im.actor.model.droidkit.bser.Bser;
import im.actor.model.droidkit.bser.BserParser;
import im.actor.model.droidkit.bser.BserObject;
import im.actor.model.droidkit.bser.BserValues;
import im.actor.model.droidkit.bser.BserWriter;
import im.actor.model.droidkit.bser.DataInput;
import im.actor.model.droidkit.bser.DataOutput;
import static im.actor.model.droidkit.bser.Utils.*;
import java.io.IOException;
import im.actor.model.network.parser.*;
import java.util.List;
import java.util.ArrayList;
import im.actor.model.api.*;

public class RequestrequestFileUploadPart extends Request<ResponserequestFileUploadPart> {

    public static final int HEADER = 0x8e;
    public static RequestrequestFileUploadPart fromBytes(byte[] data) throws IOException {
        return Bser.parse(new RequestrequestFileUploadPart(), data);
    }

    private int partNumber;
    private int partSize;
    private byte[] uploadKey;

    public RequestrequestFileUploadPart(int partNumber, int partSize, byte[] uploadKey) {
        this.partNumber = partNumber;
        this.partSize = partSize;
        this.uploadKey = uploadKey;
    }

    public RequestrequestFileUploadPart() {

    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public int getPartSize() {
        return this.partSize;
    }

    public byte[] getUploadKey() {
        return this.uploadKey;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        this.partNumber = values.getInt(1);
        this.partSize = values.getInt(2);
        this.uploadKey = values.getBytes(3);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeInt(1, this.partNumber);
        writer.writeInt(2, this.partSize);
        if (this.uploadKey == null) {
            throw new IOException();
        }
        writer.writeBytes(3, this.uploadKey);
    }

    @Override
    public String toString() {
        String res = "rpc requestFileUploadPart{";
        res += "uploadKey=" + byteArrayToStringCompact(this.uploadKey);
        res += "}";
        return res;
    }

    @Override
    public int getHeaderKey() {
        return HEADER;
    }
}
