package com.somtirtha.HDFHandler;

import hdf.hdf5lib.H5;
import hdf.hdf5lib.HDF5Constants;

public class HDFFileHandler {
	
	public static void readHDF() {

		try {
			// open file and retrieve the file structure
			// H5File h5file = new H5File("~/Downloads/h5ex_d_checksum.h5");
			// h5file.open();
			// HDFLibrary.Hopen("~/Downloads/h5ex_d_checksum.h5", 1);

			String fname = "~/Downloads/h5ex_d_checksum.h5";
			int file_id = 0;
			int faplist_id;
			int status;
			faplist_id = H5.H5Pcreate(HDF5Constants.H5P_FILE_ACCESS);
			status = H5.H5Pset_fapl_stdio(faplist_id);
			file_id = H5.H5Fopen("SampleFile.h5", HDF5Constants.H5F_ACC_RDONLY, faplist_id);

			// file_id = H5.H5Fopen(fname, HDF5Constants.H5F_ACC_RDWR,
			// HDF5Constants.H5P_DEFAULT);
			System.out.println(file_id);

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
}
