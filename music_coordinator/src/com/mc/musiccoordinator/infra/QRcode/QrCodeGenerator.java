package com.mc.musiccoordinator.infra.QRcode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mc.musiccoordinator.infra.QRcode.dto.QrCodeDTO;

public class QrCodeGenerator {

	public void generate(QrCodeDTO dto) {
		try(FileOutputStream fos = new FileOutputStream(dto.fileName() + "." + dto.format())) {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix matrix = qrCodeWriter.encode(dto.text(),  BarcodeFormat.QR_CODE, 300, 300);
            MatrixToImageWriter.writeToStream(matrix, dto.format(), new FileOutputStream(dto.fileName()));            
        } catch (WriterException | IOException e) {
        	e.printStackTrace();
        }
	}
	
}
