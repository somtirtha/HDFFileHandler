package com.somtirtha.hdfhandler;

/**
 * 
 *
 */
public class App {

	private ClassLoader classLoader;
	private static String fileName;

	public App() {
		// TODO Auto-generated constructor stub
		// get the hfd5 file
		// fileName = getClass().getClassLoader().getResource("h5ex_d_checksum.h5").getFile();
		
		// get the hdf4 file
		fileName = getClass().getClassLoader().getResource("MOD021KM.A2017224.1725.006.NRT.hdf").getFile();
	}

	public static void main(String[] args) {
		App app = new App();
		
		// create instance of hdf file handler
		HDFFileHandler hdfh = new HDFFileHandler();
		
		// read hdf5 file
		// hdfh.readHDF5(fileName);
		
		// read hdf4 file
		hdfh.readHDF4(fileName);
	}
}
