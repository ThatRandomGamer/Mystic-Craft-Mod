package com.TRGamer28.coppermod.util.helpers;

import com.google.common.cache.Cache;

import net.minecraft.util.EnumFacing;

public class EnumHelper {

	public static EnumFacing rotateRight(EnumFacing facing) {
		EnumFacing CACHE = null;
		switch (facing) {
		case DOWN:
			CACHE = facing;
			break;
		case EAST:
			CACHE = EnumFacing.NORTH;
			break;
		case NORTH:
			CACHE = EnumFacing.WEST;
			break;
		case SOUTH:
			CACHE = EnumFacing.EAST;
			break;
		case UP:
			CACHE = facing;
			break;
		case WEST:
			CACHE = EnumFacing.SOUTH;
			break;
		}

		return CACHE != null ? CACHE : facing;
	}

	public static EnumFacing rotateLeft(EnumFacing facing) {
		EnumFacing CACHE = null;
		switch (facing) {
		case DOWN:
			CACHE = facing;
			break;
		case EAST:
			CACHE = EnumFacing.SOUTH;
			break;
		case NORTH:
			CACHE = EnumFacing.EAST;
			break;
		case SOUTH:
			CACHE = EnumFacing.WEST;
			break;
		case UP:
			CACHE = facing;
			break;
		case WEST:
			CACHE = EnumFacing.NORTH;
			break;
		}

		return CACHE != null ? CACHE : facing;
	}

	public static EnumFacing getOffsetFacingWithProperty(EnumFacing offset, EnumFacing property) {
		EnumFacing CACHE = null;
		switch (property) {
		case DOWN:
			CACHE = offset;
			break;
		case EAST:
			CACHE = rotateLeft(offset);
			break;
		case NORTH:
			CACHE = offset;
			break;
		case SOUTH:
			CACHE = rotateLeft(rotateLeft(offset));
			break;
		case UP:
			CACHE = offset;
			break;
		case WEST:
			CACHE = rotateRight(offset);
			break;
		}
		
		return CACHE != null ? CACHE : offset;
	}
}